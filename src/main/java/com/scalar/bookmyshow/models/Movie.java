package com.scalar.bookmyshow.models;




import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends BaseModel{
    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Language> languages;

}
