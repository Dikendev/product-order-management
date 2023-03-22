package com.system.productorder.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "tb_user")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    @JsonIgnore    // ignore the field when converting the object to JSON format.
    @OneToMany(mappedBy = "client")  // a client can have many orders.
    private List<Order> orders = new ArrayList<>();

    public User() {
    }

    public User(Long id, String name, String email, String phone, String password) {
        super();
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    public boolean equals(Object obj) {
        if(this == obj)
            return  true;
        if(obj == null)
            return false;
        if(getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        if(id == null) {
            if (other.id != null)
                return false;
        } else if(!id.equals(other.id))
            return false;
        return true;
    }
}