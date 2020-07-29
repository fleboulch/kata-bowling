package resolvers;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Repeatable(FrameConfig.FramesConfig.class)
public @interface FrameConfig {

    int firstBall() default 0;
    int secondBall() default 0;
    int number() default 1;

    @Target({ElementType.PARAMETER})
    @Retention(RetentionPolicy.RUNTIME)
    @interface FramesConfig {

        FrameConfig[] value();
    }

}
