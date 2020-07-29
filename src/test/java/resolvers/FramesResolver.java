package resolvers;

import com.fleboulch.bowling.domain.Frame;
import com.fleboulch.bowling.domain.Frames;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class FramesResolver implements ParameterResolver {

    private static final int VALID_NUMBER_OF_FRAMES = 10;

    private static final Frame ZERO_FRAME = new Frame(0, 0, 1);

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType() == Frames.class;
    }

    @Override
    public Object resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        List<Frame> frames = new ArrayList<>();

        IntStream.rangeClosed(1, VALID_NUMBER_OF_FRAMES).forEach(t -> {

            if (parameterContext.isAnnotated(EachFrameConfig.class)) {
                int firstBall = parameterContext.getParameter().getAnnotation(EachFrameConfig.class).firstBall();
                int secondBall = parameterContext.getParameter().getAnnotation(EachFrameConfig.class).secondBall();

                frames.add(new Frame(firstBall, secondBall));
            } else {
                frames.add(ZERO_FRAME);
            }
        });

        FrameConfig[] framesConfig = parameterContext.getParameter().getAnnotationsByType(FrameConfig.class);
        for (FrameConfig frame : framesConfig) {
            frames.set(frame.number() - 1, new Frame(frame.firstBall(), frame.secondBall()));
        }

        return new Frames(frames);
    }
}
