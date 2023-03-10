package es.tfc.marcosm.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class RoleDTO {
    public Integer id;
    public String name;
    public String description;
}
