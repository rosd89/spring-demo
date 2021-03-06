package sam.member;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.*;

/**
 * Created by sam on 2016. 11. 25..
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "member")
@XmlType(name = "", propOrder = {"id", "email", "name", "imagePath"})
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Member {

    public Member(){}

    public Member(String id, String email, String name){
        this.id = id;
        this.email = email;
        this.name = name;
    }

    @NotNull()
    @Size(min=2, max=30, message = "INVALID-PARAM-NAME")
    @Getter
    @Setter
    private String id;

    //@Pattern(regexp = "/^[0-9a-zA-Z]([\\-.\\w]*[0-9a-zA-Z\\-_+])*@([0-9a-zA-Z][\\-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9}$/")
    @Getter
    @Setter
    private String email;

    @Size(min=2, max=30, message = "INVALID-PARAM-NAME")
    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String imagePath;
}
