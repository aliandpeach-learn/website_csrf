package com.yk.model;

import java.io.Serializable;

public class User implements Serializable
{
    private static final long serialVersionUID = 7393954340656555797L;

    private String id;

    private String name;

    private String password;

    public User(String name, String password)
    {
        this.name = name;
        this.password = password;
    }

    public User()
    {
    }

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }
}
