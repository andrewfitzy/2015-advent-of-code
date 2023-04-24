/* (C)2022 */
package io.github.andrewfitzy;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class TaskInputReader {

    public static final List<String> getFileContent(final String fileName) {
        List<String> result;
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        URL resource = classloader.getResource(fileName);
        try (Stream<String> lines = Files.lines(Path.of(resource.toURI()))) {
            result = lines.collect(Collectors.toList());
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
