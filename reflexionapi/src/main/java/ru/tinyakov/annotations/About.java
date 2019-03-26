package ru.tinyakov.annotations;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface About {
    String info() default "default info about";
}
