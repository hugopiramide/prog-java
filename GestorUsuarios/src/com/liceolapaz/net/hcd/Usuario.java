package com.liceolapaz.net.hcd;

public class Usuario {
    private int id;
    private String email;
    private String firs_name;
    private String last_name;
    private String avatar;

    public Usuario(int id, String email, String firs_name, String last_name, String avatar) {
        this.id = id;
        this.email = email;
        this.firs_name = firs_name;
        this.last_name = last_name;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return "  {\n" +
                "    \"id\": "+ id + ",\n" +
                "    \"email\": \""+ email +"\",\n" +
                "    \"first_name\": \""+ firs_name +"\",\n" +
                "    \"last_name\": \"" + last_name + "\",\n" +
                "    \"avatar\": \"" + avatar + "\"\n" +
                "  }";
    }
}
