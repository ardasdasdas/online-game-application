package tr.com.estu.onlinegameapplication.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.util.List;

public class Mapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    static {
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    }

    public static <S, D> D map(S source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public static <S, D> List<D> mapList(List<S> sourceList, Class<D> destinationType) {
        return sourceList.stream()
                .map(source -> modelMapper.map(source, destinationType))
                .toList();
    }

    private Mapper() {
        throw new IllegalStateException("Mapper class should not be instantiated!");
    }
}
