package fr.cg95.cvq.util;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.oval.ConstraintViolation;
import net.sf.oval.context.ClassContext;
import net.sf.oval.context.FieldContext;
import net.sf.oval.context.OValContext;

import org.apache.commons.lang.StringUtils;

public class ValidationUtils {

    public static void collectInvalidFields(ConstraintViolation violation,
        Map<String, List<String>> fields, String prefix, String profile)
        throws ClassNotFoundException,  IllegalAccessException, InvocationTargetException,
            NoSuchMethodException {
        Class<? extends Annotation> annotationClass =
            Class.forName(violation.getErrorCode()).asSubclass(Annotation.class);
        if (violation.getCauses() == null) {
            String field;
            if (violation.getContext() instanceof ClassContext)
                field = prefix;
            else {
                String[] profiles = (String[])annotationClass.getMethod("profiles").invoke(
                    ((FieldContext)violation.getContext()).getField().getAnnotation(annotationClass));
                if (profiles != null && profiles.length > 0)
                    profile = profiles[0];
                field = (StringUtils.isNotBlank(prefix) ? prefix + '.' : "") + violation.getMessage();
            }
            if (fields.get(profile) == null)
                fields.put(profile, new ArrayList<String>());
            fields.get(profile).add(field);
        } else {
            OValContext context = violation.getContext();
            String[] profiles = (String[])annotationClass.getMethod("profiles").invoke(
                ((FieldContext)context).getField().getAnnotation(annotationClass));
            if (profiles != null && profiles.length > 0)
                profile = profiles[0];
            for (ConstraintViolation cause : violation.getCauses()) {
                collectInvalidFields(
                    cause, fields,
                    (StringUtils.isNotBlank(prefix) ? prefix + '.' : "") + violation.getMessage()
                        + (List.class.isAssignableFrom(context.getCompileTimeType()) ?
                            "[" + ((List<?>)((FieldContext)context).getField().get(violation.getValidatedObject()))
                                .indexOf(cause.getValidatedObject()) + "]" : ""),
                    profile);
            }
        }
    }
}
