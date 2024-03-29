package com.br.cars.conversion;

import javax.persistence.AttributeConverter;
import java.util.logging.Logger;

public class IdChassiGenerator implements AttributeConverter<Long, String> {

    //LOGGER PARA TENTAR VER O PQ NÃO ESSE METODO NÃO ESTA FUNCIONANDO
    private static final Logger logger = Logger.getLogger(IdChassiGenerator.class.getName());

    //METODOS DE CONVERSÃO
    @Override
    public String convertToDatabaseColumn(Long idChassi) {
        logger.info("Convertendo idChassi para String: " + idChassi);
        return String.format("CAR-%03d", idChassi);
    }

    @Override
    public Long convertToEntityAttribute(String entity) {
        logger.info("Convertendo String para idChassi: " + entity);
        return Long.parseLong(entity);
    }
}


