/* (C)2023 */
package io.github.andrewfitzy.day_12;

import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task02 {
    public final Pattern NUMBER_PATTERN = Pattern.compile("-?\\d+");
    private final List<String> fileContent;

    public Task02(final List<String> fileContent) {
        this.fileContent = fileContent.stream().toList();
    }

    public int solve() {
        String input = fileContent.get(0);

        StringBuilder builder = new StringBuilder();
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode node = objectMapper.readTree(input);
            processJSONTree(node);
            builder.append(objectMapper.writeValueAsString(node));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Matcher matcher = NUMBER_PATTERN.matcher(builder.toString());
        int total = 0;
        while (matcher.find()) {
            total = total + Integer.parseInt(matcher.group());
        }
        return total;
    }

    public void processJSONTree(JsonNode root) {
        if (root.isObject() && nodeContainsRed(root)) {
            ObjectNode node = (ObjectNode) root;
            node.removeAll();
        }
        processNode(root);
    }

    private void processNode(JsonNode node) {
        for (Iterator<JsonNode> nodeElements = node.elements(); nodeElements.hasNext(); ) {
            JsonNode nodeElement = nodeElements.next();
            boolean containsRed = nodeContainsRed(nodeElement);
            if (containsRed) {
                nodeElements.remove();
            }
        }

        for (Iterator<JsonNode> nodeElements = node.elements(); nodeElements.hasNext(); ) {
            JsonNode nodeElement = nodeElements.next();
            processNode(nodeElement);
        }
    }

    private boolean nodeContainsRed(JsonNode node) {
        if (node.isObject()) {
            for (Iterator<Map.Entry<String, JsonNode>> nodeFields = node.fields(); nodeFields.hasNext(); ) {
                Map.Entry<String, JsonNode> entry = nodeFields.next();

                JsonNode tmpNode = entry.getValue();
                if (tmpNode.isValueNode() && "red".equals(tmpNode.asText())) {
                    return true;
                }
            }
        }
        return false;
    }
}
