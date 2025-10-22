package com.example;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class ApplicationContext {

    public ApplicationContext(String packageName) throws IOException {
        initContext(packageName);
    }


    public void initContext(String packageName) throws IOException {
        scanPackage(packageName).stream().filter(this::scanCreate).map(this::wrapper).forEach(this::createBean);
    }

    protected boolean scanCreate(Class<?> type) {
        return type.isAnnotationPresent(Component.class);
    }

    protected void createBean(BeanDefinition beanDefinition) {

    }

    protected BeanDefinition wrapper(Class<?> type) {
        return new BeanDefinition(type);
    }


    public List<Class<?>> scanPackage(String packageName) throws IOException {
        URL resource = this.getClass().getClassLoader().getResource(packageName.replace(".", File.separator));
        Path path = Path.of(resource.getFile());
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path absolutePath = file.toAbsolutePath();
                if (absolutePath.toString().endsWith(".class")) {
                    System.out.println(absolutePath);
                }
                return FileVisitResult.CONTINUE;
            }
        });
        return null;
    }

    public Object getBean(String beanName) {
        return null;

    }

    public <T> T getBean(Class<T> beanType) {
        return null;

    }

    public <T> List<T> getBeans(Class<T> beanType) {
        return null;
    }
}
