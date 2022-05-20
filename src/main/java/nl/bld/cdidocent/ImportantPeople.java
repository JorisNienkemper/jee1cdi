package nl.bld.cdidocent;

import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD,TYPE,PARAMETER,FIELD})
@Retention(RUNTIME)
@Qualifier
public @interface ImportantPeople {
}
