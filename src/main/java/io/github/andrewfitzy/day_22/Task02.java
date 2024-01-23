/* (C)2023 */
package io.github.andrewfitzy.day_22;

import java.util.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class Task02 {

    final Logger logger = LoggerFactory.getLogger(Task02.class);

    private record Spell(String name, int cost, int damage, int healsHP, int armour, int manaRecharge, int turns) {}

    private record GameState(
            int playerHP,
            int playerMana,
            int playerArmor,
            int bossHP,
            int bossDamage,
            int manaSpent,
            Map<String, Integer> activeSpells) {
        public boolean isWon() {
            return this.bossHP <= 0 || this.playerHP <= 0;
        }
    }

    private final Map<String, Spell> spells = new HashMap<>();

    private final Set<Spell> instantSpells = new HashSet<>();

    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
        spells.put("Magic Missile", new Spell("Magic Missile", 53, 4, 0, 0, 0, 1));
        spells.put("Drain", new Spell("Drain", 73, 2, 2, 0, 0, 1));
        spells.put("Shield", new Spell("Shield", 113, 0, 0, 7, 0, 6));
        spells.put("Poison", new Spell("Poison", 173, 3, 0, 0, 0, 6));
        spells.put("Recharge", new Spell("Recharge", 229, 0, 0, 0, 101, 5));

        instantSpells.add(spells.get("Magic Missile"));
        instantSpells.add(spells.get("Drain"));
    }

    public int solve(int playerHitPoints, int playerMana) {
        int bossHP =
                Integer.parseInt(fileContent.get(0).replace("Hit Points: ", "").trim());
        int bossDamage =
                Integer.parseInt(fileContent.get(1).replace("Damage: ", "").trim());
        final GameState startGameState =
                new GameState(playerHitPoints, playerMana, 0, bossHP, bossDamage, 0, new HashMap<>());

        Random rand = new Random();

        List<String> strategy = new ArrayList<>();
        int lowestMana = Integer.MAX_VALUE;
        for (int i = 0; i < 100000; i++) {
            List<String> currentStrategy = new ArrayList<>();

            // first apply any existing spells
            GameState gameState = applySpells(startGameState);

            while (!gameState.isWon()) {
                // --- Players turn ---
                // First remove 1 hp as we're in hard mode
                gameState = hardMode(gameState);
                if (gameState.isWon()) {
                    // boss wins
                    break;
                }

                // then apply the spells.
                gameState = applySpells(gameState);
                if (gameState.isWon()) {
                    if (gameState.manaSpent < lowestMana) {
                        lowestMana = gameState.manaSpent;
                        strategy.clear();
                        strategy.addAll(currentStrategy);
                    }
                    break;
                }

                // then get possible spells, we can buy one on the round when it's ended
                List<Spell> possibleSpells = getPossibleSpells(gameState);

                // If the player can buy a spell...
                if (possibleSpells.size() > 0) {
                    // choose a random spell
                    int random = rand.nextInt(possibleSpells.size());

                    // purchase the spell to reduce the mana
                    Spell randomSpell = possibleSpells.get(random);

                    // store the name of the spell
                    currentStrategy.add(randomSpell.name);

                    // purchase the spell
                    gameState = purchaseSpell(randomSpell, gameState);

                    // check if spell could be purchased
                    if (isInstantSpell(randomSpell) && gameState.activeSpells().containsKey(randomSpell.name())) {
                        // apply the spell
                        gameState = applySpell(randomSpell, gameState);
                    }

                    // check if the game is won for player
                    if (gameState.isWon()) {
                        if (gameState.manaSpent < lowestMana) {
                            lowestMana = gameState.manaSpent;
                            strategy.clear();
                            strategy.addAll(currentStrategy);
                        }
                        break;
                    }
                }

                // --- Bosses turn ---
                // first apply the spells
                gameState = applySpells(gameState);

                // check if the game is won for player
                if (gameState.isWon()) {
                    if (gameState.manaSpent < lowestMana) {
                        lowestMana = gameState.manaSpent;
                        strategy.clear();
                        strategy.addAll(currentStrategy);
                    }
                    break;
                }

                // Perform bosses attack
                gameState = bossAttack(gameState);
            }
        }
        logger.info(strategy.toString());
        return lowestMana;
    }

    GameState hardMode(GameState currentState) {
        int playerHP = currentState.playerHP - 1;
        int playerMana = currentState.playerMana;
        int playerArmor = currentState.playerArmor;
        int bossHP = currentState.bossHP;
        int bossDamage = currentState.bossDamage;
        int manaSpent = currentState.manaSpent;
        Map<String, Integer> activeSpells = new HashMap<>(currentState.activeSpells);

        return new GameState(playerHP, playerMana, playerArmor, bossHP, bossDamage, manaSpent, activeSpells);
    }

    boolean isInstantSpell(Spell randomSpell) {
        return instantSpells.contains(randomSpell);
    }

    List<Spell> getPossibleSpells(GameState state) {
        List<Spell> possibleSpells = new ArrayList<>();
        for (Spell spell : spells.values()) {
            int remainingSpellTime = state.activeSpells().getOrDefault(spell.name(), 1);
            if (state.playerMana >= spell.cost() && remainingSpellTime <= 1) {
                possibleSpells.add(spell);
            }
        }
        return possibleSpells;
    }

    GameState purchaseSpell(Spell spell, GameState currentState) {
        int playerHP = currentState.playerHP;
        int playerMana = currentState.playerMana - spell.cost;
        int playerArmor = currentState.playerArmor;
        int bossHP = currentState.bossHP;
        int bossDamage = currentState.bossDamage;
        int manaSpent = currentState.manaSpent + spell.cost;
        Map<String, Integer> activeSpells = currentState.activeSpells;
        activeSpells.put(spell.name, spell.turns);

        return new GameState(playerHP, playerMana, playerArmor, bossHP, bossDamage, manaSpent, activeSpells);
    }

    GameState applySpells(GameState currentState) {
        GameState tmpState = new GameState(
                currentState.playerHP(),
                currentState.playerMana(),
                0,
                currentState.bossHP(),
                currentState.bossDamage(),
                currentState.manaSpent(),
                new HashMap<>(currentState.activeSpells()));
        for (String spellName : currentState.activeSpells.keySet()) {
            Spell spell = spells.get(spellName);
            tmpState = applySpell(spell, tmpState);
        }
        return tmpState;
    }

    GameState applySpell(Spell spell, GameState currentState) {
        int playerHP = currentState.playerHP + spell.healsHP;
        int playerMana = currentState.playerMana + spell.manaRecharge;
        int playerArmor = currentState.playerArmor + spell.armour;
        int bossHP = currentState.bossHP - spell.damage;
        int bossDamage = currentState.bossDamage;
        int manaSpent = currentState.manaSpent;

        Map<String, Integer> remainingSpells = new HashMap<>(currentState.activeSpells);

        int turnsLeft = remainingSpells.remove(spell.name()) - 1;
        if (turnsLeft > 0) {
            remainingSpells.put(spell.name(), turnsLeft);
        }

        return new GameState(playerHP, playerMana, playerArmor, bossHP, bossDamage, manaSpent, remainingSpells);
    }

    GameState bossAttack(GameState currentState) {
        int playerHP = currentState.playerHP;
        int playerMana = currentState.playerMana;
        int playerArmor = currentState.playerArmor;
        int bossHP = currentState.bossHP;
        int bossDamage = currentState.bossDamage;
        int manaSpent = currentState.manaSpent;
        Map<String, Integer> activeSpells = currentState.activeSpells;

        int netAttackPoints = bossDamage - playerArmor;
        int bossAttack = Math.max(1, netAttackPoints);
        playerHP = playerHP - bossAttack;

        return new GameState(playerHP, playerMana, playerArmor, bossHP, bossDamage, manaSpent, activeSpells);
    }
}
