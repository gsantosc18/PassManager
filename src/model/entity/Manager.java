package model.entity;
// Generated 25/04/2018 20:14:49 by Hibernate Tools 4.3.1


import java.util.Date;

/**
 * Manager generated by hbm2java
 */
public class Manager  implements java.io.Serializable {


     private Integer idManager;
     private Usuario usuario;
     private String titulo;
     private String usuario_1;
     private String email;
     private String senha;
     private String url;
     private Date cadastro;

    public Manager() {
    }

	
    public Manager(Usuario usuario, String titulo, String usuario_1, String email, String senha) {
        this.usuario = usuario;
        this.titulo = titulo;
        this.usuario_1 = usuario_1;
        this.email = email;
        this.senha = senha;
    }
    public Manager(Usuario usuario, String titulo, String usuario_1, String email, String senha, String url, Date cadastro) {
       this.usuario = usuario;
       this.titulo = titulo;
       this.usuario_1 = usuario_1;
       this.email = email;
       this.senha = senha;
       this.url = url;
       this.cadastro = cadastro;
    }
   
    public Integer getIdManager() {
        return this.idManager;
    }
    
    public void setIdManager(Integer idManager) {
        this.idManager = idManager;
    }
    public Usuario getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public String getTitulo() {
        return this.titulo;
    }
    
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getUsuario_1() {
        return this.usuario_1;
    }
    
    public void setUsuario_1(String usuario_1) {
        this.usuario_1 = usuario_1;
    }
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return this.senha;
    }
    
    public void setSenha(String senha) {
        this.senha = senha;
    }
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    public Date getCadastro() {
        return this.cadastro;
    }
    
    public void setCadastro(Date cadastro) {
        this.cadastro = cadastro;
    }




}


