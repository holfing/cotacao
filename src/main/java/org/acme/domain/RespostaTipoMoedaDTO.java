package org.acme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RespostaTipoMoedaDTO implements BaseDTO {

    @JsonProperty("@odata.context")
    private String dataContext;

    private List<TipoMoedaDTO> value;

    public List<TipoMoedaDTO> getValue() {
        return value;
    }

    public void setValue(List<TipoMoedaDTO> value) {
        this.value = value;
    }

    public String getDataContext() {
        return dataContext;
    }

    public void setDataContext(String dataContext) {
        this.dataContext = dataContext;
    }
}
