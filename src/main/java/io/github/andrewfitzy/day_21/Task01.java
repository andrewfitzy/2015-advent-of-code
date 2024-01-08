/* (C)2023 */
package io.github.andrewfitzy.day_21;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Task01 {

    public static final String BOSS = "BOSS";

    public static final String PLAYER = "PLAYER";

    private record Stats(int cost, int damage, int armor) {}

    public record Player(int hitPoints, int damage, int armor) {}

    private record Equipment(String weapon, String armor, String leftHand, String rightHand) {}

    private final Map<String, Stats> weaponStats;
    private final Map<String, Stats> armorStats;
    private final Map<String, Stats> ringStats;
    private final List<String> fileContent;

    public Task01(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();

        weaponStats = new HashMap<>();
        weaponStats.put("Dagger", new Stats(8, 4, 0));
        weaponStats.put("Shortsword", new Stats(10, 5, 0));
        weaponStats.put("Warhammer", new Stats(25, 6, 0));
        weaponStats.put("Longsword", new Stats(40, 7, 0));
        weaponStats.put("Greataxe", new Stats(74, 8, 0));

        armorStats = new HashMap<>();
        armorStats.put("None", new Stats(0, 0, 0));
        armorStats.put("Leather", new Stats(13, 0, 1));
        armorStats.put("Chainmail", new Stats(31, 0, 2));
        armorStats.put("Splintmail", new Stats(53, 0, 3));
        armorStats.put("Bandedmail", new Stats(75, 0, 4));
        armorStats.put("Platemail", new Stats(102, 0, 5));

        ringStats = new HashMap<>();
        ringStats.put("None", new Stats(0, 0, 0));
        ringStats.put("Damage +1", new Stats(25, 1, 0));
        ringStats.put("Damage +2", new Stats(50, 2, 0));
        ringStats.put("Damage +3", new Stats(100, 3, 0));
        ringStats.put("Defense +1", new Stats(20, 0, 1));
        ringStats.put("Defense +2", new Stats(40, 0, 2));
        ringStats.put("Defense +3", new Stats(80, 0, 3));
    }

    public int solve() {
        String[] bossHitPointParts = fileContent.get(0).split(" ");
        int bossHitPoints = Integer.parseInt(bossHitPointParts[bossHitPointParts.length - 1]);
        String[] bossDamageParts = fileContent.get(1).split(" ");
        int bossDamage = Integer.parseInt(bossDamageParts[bossDamageParts.length - 1]);
        String[] bossArmorParts = fileContent.get(2).split(" ");
        int bossArmor = Integer.parseInt(bossArmorParts[bossArmorParts.length - 1]);

        Player boss = new Player(bossHitPoints, bossDamage, bossArmor);
        Player player = new Player(100, 0, 0);

        int lowestCost = Integer.MAX_VALUE;
        List<Equipment> itemCombinations = getCombinations();
        for (Equipment equipment : itemCombinations) {
            Player equipedPlayer = equipPlayer(player, equipment);
            String winner = getChampion(equipedPlayer, boss);
            if (PLAYER.equals(winner)) {
                int equipmentCost = getEquipmentCost(equipment);
                if (equipmentCost < lowestCost) {
                    lowestCost = equipmentCost;
                }
            }
        }
        return lowestCost;
    }

    private int getEquipmentCost(Equipment equipment) {
        return weaponStats.get(equipment.weapon()).cost()
                + armorStats.get(equipment.armor()).cost()
                + ringStats.get(equipment.leftHand()).cost()
                + ringStats.get(equipment.rightHand()).cost();
    }

    private Player equipPlayer(Player player, Equipment equipment) {
        Stats weapon = weaponStats.get(equipment.weapon());
        Stats armor = armorStats.get(equipment.armor());
        Stats leftHand = ringStats.get(equipment.leftHand());
        Stats rightHand = ringStats.get(equipment.rightHand());

        int totalDamage = weapon.damage() + armor.damage() + leftHand.damage() + rightHand.damage();
        int totalArmor = weapon.armor() + armor.armor() + leftHand.armor() + rightHand.armor();
        return new Player(player.hitPoints(), totalDamage, totalArmor);
    }

    private List<Equipment> getCombinations() {
        List<Equipment> equipmentList = new ArrayList<>();
        for (Map.Entry<String, Stats> weapon : weaponStats.entrySet()) {
            for (Map.Entry<String, Stats> armor : armorStats.entrySet()) {
                for (Map.Entry<String, Stats> leftRing : ringStats.entrySet()) {
                    for (Map.Entry<String, Stats> rightRing : ringStats.entrySet()) {
                        if (leftRing.getKey().equals(rightRing.getKey())) {
                            equipmentList.add(
                                    new Equipment(weapon.getKey(), armor.getKey(), leftRing.getKey(), "None"));
                        } else {
                            equipmentList.add(new Equipment(
                                    weapon.getKey(), armor.getKey(), leftRing.getKey(), rightRing.getKey()));
                        }
                    }
                }
            }
        }
        return equipmentList;
    }

    String getChampion(final Player player, final Player boss) {
        String whoseGo = PLAYER;
        boolean winnerFound = false;
        Player tmpPlayer = player;
        Player tmpBoss = boss;
        while (!winnerFound) {
            Player attacker = (PLAYER.equals(whoseGo)) ? tmpPlayer : tmpBoss;
            Player defender = (PLAYER.equals(whoseGo)) ? tmpBoss : tmpPlayer;
            int damage = attacker.damage() - defender.armor();
            int damageDealt = (damage <= 0) ? 1 : damage;
            int remainingHitpoints = defender.hitPoints() - damageDealt;
            if (remainingHitpoints <= 0) {
                winnerFound = true;
                continue;
            }
            if (PLAYER.equals(whoseGo)) {
                tmpBoss = new Player(remainingHitpoints, tmpBoss.damage(), tmpBoss.armor());
                whoseGo = BOSS;
            } else {
                tmpPlayer = new Player(remainingHitpoints, tmpPlayer.damage(), tmpPlayer.armor());
                whoseGo = PLAYER;
            }
        }
        return whoseGo;
    }
}
