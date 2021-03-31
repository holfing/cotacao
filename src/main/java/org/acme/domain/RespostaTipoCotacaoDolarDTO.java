package org.acme.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RespostaTipoCotacaoDolarDTO implements BaseDTO {

    @JsonProperty("@odata.context")
    private String dataContext;

    private List<TipoCotacaoDolarDTO> value;

    public List<TipoCotacaoDolarDTO> getValue() {
        return value;
    }

    public void setValue(List<TipoCotacaoDolarDTO> value) {
        this.value = value;
    }

    public String getDataContext() {
        return dataContext;
    }

    public void setDataContext(String dataContext) {
        this.dataContext = dataContext;
    }
}
