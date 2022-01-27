package com.tenniscourts.tenniscourts;

import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-26T19:19:50-0500",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_301 (Oracle Corporation)"
)
@Component
public class TennisCourtMapperImpl implements TennisCourtMapper {

    @Override
    public TennisCourtDTO map(TennisCourt source) {
        if ( source == null ) {
            return null;
        }

        TennisCourtDTO tennisCourtDTO = new TennisCourtDTO();

        tennisCourtDTO.setId( source.getId() );
        tennisCourtDTO.setName( source.getName() );

        return tennisCourtDTO;
    }

    @Override
    public TennisCourt map(TennisCourtDTO source) {
        if ( source == null ) {
            return null;
        }

        TennisCourt tennisCourt = new TennisCourt();

        tennisCourt.setId( source.getId() );
        tennisCourt.setName( source.getName() );

        return tennisCourt;
    }
}
