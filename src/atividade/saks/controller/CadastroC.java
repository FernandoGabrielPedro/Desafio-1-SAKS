package atividade.saks.controller;

import atividade.saks.criptografia.Criptografia;
import atividade.saks.view.LoginMain;
import atividade.saks.dao.AdminDAO;
import atividade.saks.dao.UsuarioDAO;
import atividade.saks.model.Admin;
import atividade.saks.model.Usuario;
import atividade.saks.view.*;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;

/**
 *
 * @author ferna
 */
public class CadastroC {
    
    //Comentário extremamente útil e informativo
    
    //Comentário PERIGOSÍSSIMO
    
    public static void main(String[] args) {
        LoginMain loginMain = new LoginMain();
        loginMain.setVisible(true);
    }
    
    public static boolean AbrirAba(LoginMain loginMain, String email, String senha) {
        Usuario buscaUsuario = new Usuario();
        Admin buscaAdmin = new Admin();
        
        buscaUsuario = UsuarioDAO.UsuarioLogin(email,senha);
        if (buscaUsuario != null) {
            VisualizarUsuario visualizarUsuario = new VisualizarUsuario(buscaUsuario);
            visualizarUsuario.setVisible(true);
        } else {
            buscaAdmin = AdminDAO.AdminLogin(email,senha);
            if (buscaAdmin != null) {
                AbaAdmin abaAdmin = new AbaAdmin(buscaAdmin);
                abaAdmin.setVisible(true);
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static boolean AbrirAbaAdm(String email) {
        Usuario usuarioPorEmail = UsuarioDAO.GetUsuarioPorEmail(email);
        Admin adminPorEmail = AdminDAO.GetAdminPorEmail(email);
        if(usuarioPorEmail != null) {
            VisualizarUsuario visualizarUsuario = new VisualizarUsuario(usuarioPorEmail);
            visualizarUsuario.setVisible(true);
        } else if(adminPorEmail != null) {
            VisualizarUsuario visualizarUsuario = new VisualizarUsuario(adminPorEmail);
            visualizarUsuario.setVisible(true);
        } else {
            return false;
        }
        return true;
    }
    
    public static void RecSenhaAba() {
        RecuperarSenha recuperarSenha = new RecuperarSenha();
        recuperarSenha.setVisible(true);
    }
    
    public static void CadastrarUsuarioAba() {
        CadastrarUsuario cadastrarUsuario = new CadastrarUsuario();
        cadastrarUsuario.setVisible(true);
    }
    
    public static void CadastrarAdminAba() {
        CadastrarAdmin cadastrarAdmin = new CadastrarAdmin();
        cadastrarAdmin.setVisible(true);
    }
    
    public static void AltPar(Usuario usuario, Admin admin, String parametro, VisualizarUsuario visualizarUsuario) {
        if(usuario != null) {
            if("senha".equals(parametro)) {
                AlterarSenha alterarSenha = new AlterarSenha(parametro,usuario);
                alterarSenha.setVisible(true);
            } else {
                AlterarParametro alterarParametro = new AlterarParametro(parametro,usuario,visualizarUsuario);
                alterarParametro.setVisible(true);
            }
        } else {
            if("senha".equals(parametro)) {
                AlterarSenha alterarSenha = new AlterarSenha(parametro,admin);
                alterarSenha.setVisible(true);
            } else {
                AlterarParametro alterarParametro = new AlterarParametro(parametro,admin,visualizarUsuario);
                alterarParametro.setVisible(true);
            }
        }
    }
    
    public static void AltPar(Usuario usuario, Admin admin, String parametro) {
        if(usuario != null) {
            if("senha".equals(parametro)) {
                AlterarSenha alterarSenha = new AlterarSenha(parametro,usuario);
                alterarSenha.setVisible(true);
            } else {
                AlterarParametro alterarParametro = new AlterarParametro(parametro,usuario);
                alterarParametro.setVisible(true);
            }
        } else {
            if("senha".equals(parametro)) {
                AlterarSenha alterarSenha = new AlterarSenha(parametro,admin);
                alterarSenha.setVisible(true);
            } else {
                AlterarParametro alterarParametro = new AlterarParametro(parametro,admin);
                alterarParametro.setVisible(true);
            }
        }
    }
    
    public static boolean CadastrarUsuario(String nome, int idade, String cpf, String email, String senha, String pergunta1, String pergunta2, String pergunta3) {
        Usuario usuario = new Usuario();
        
        if("".equals(nome) || "".equals(cpf) || "".equals(email) || "".equals(senha) || "".equals(pergunta1) || "".equals(pergunta2) || "".equals(pergunta3))
            return false;
        
        Usuario usuarioEmailTeste = UsuarioDAO.GetUsuarioPorEmail(email);
        Admin adminEmailTeste = AdminDAO.GetAdminPorEmail(email);
        if(usuarioEmailTeste != null || adminEmailTeste != null) {
            return false;
        }
        
        usuario.setNome(nome);
        usuario.setIdade(idade);
        usuario.setCpf(cpf);
        usuario.setEmail(email);
        usuario.setSenha(senha);
        usuario.setPergunta1(pergunta1);
        usuario.setPergunta2(pergunta2);
        usuario.setPergunta3(pergunta3);
        
        try {
            UsuarioDAO.CadastrarUsuario(usuario);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            usuario = null;
        }
        return true;
    }
    
    public static boolean CadastrarAdmin(String nome, int idade, String cpf, String email, String senha, String pergunta1, String pergunta2, String pergunta3) {
        Admin admin = new Admin();
        
        Usuario usuarioEmailTeste = UsuarioDAO.GetUsuarioPorEmail(email);
        Admin adminEmailTeste = AdminDAO.GetAdminPorEmail(email);
        if(usuarioEmailTeste != null || adminEmailTeste != null) {
            return false;
        }
        
        admin.setNome(nome);
        admin.setIdade(idade);
        admin.setCpf(cpf);
        admin.setEmail(email);
        admin.setSenha(senha);
        admin.setPergunta1(pergunta1);
        admin.setPergunta2(pergunta2);
        admin.setPergunta3(pergunta3);
        
        try {
            AdminDAO.CadastrarAdmin(admin);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            admin = null;
        }
        return true;
    }
    
    public static boolean RecSenha(RecuperarSenha recuperarSenha, String email, String pergunta1, String pergunta2, String pergunta3) {
        Usuario usuario = new Usuario();
        Admin admin = new Admin();
        
        usuario = UsuarioDAO.GetUsuarioRedefinirSenha(email,pergunta1,pergunta2,pergunta3);
        if (usuario != null) {
            AlterarSenha alterarSenha = new AlterarSenha("senha",usuario);
            alterarSenha.setVisible(true);
            recuperarSenha.dispose();
        } else {
            admin = AdminDAO.GetAdminRedefinirSenha(email,pergunta1,pergunta2,pergunta3);
            if (admin != null) {
                AlterarSenha alterarSenha = new AlterarSenha("senha",admin);
                alterarSenha.setVisible(true);
                recuperarSenha.dispose();
            } else {
                return false;
            }
        }
        return true;
    }
    
    public static void AlterarParametro(Usuario usuario, Admin admin, String parametro, String newAtributo) {
        if ("senha".equals(parametro))
            newAtributo = Criptografia.Criptografar(newAtributo);
        if (usuario != null)
            usuario = UsuarioDAO.EditarUsuario(usuario,parametro,newAtributo);
        else
            admin = AdminDAO.EditarAdmin(admin,parametro,newAtributo);
    }
    
    public static Usuario AlterarParametro(Usuario usuario, String parametro, String newAtributo) {
        if ("senha".equals(parametro))
            newAtributo = Criptografia.Criptografar(newAtributo);
        usuario = UsuarioDAO.EditarUsuario(usuario,parametro,newAtributo);
        return usuario;
    }
    
    public static Admin AlterarParametro(Admin admin, String parametro, String newAtributo) {
        if ("senha".equals(parametro))
            newAtributo = Criptografia.Criptografar(newAtributo);
        admin = AdminDAO.EditarAdmin(admin,parametro,newAtributo);
        return admin;
    }
    
    public static void DeletCadastro(Usuario usuario, Admin admin) {
        if(admin == null) {
            usuario = UsuarioDAO.DeletarUsuario(usuario);
        } else {
            admin = AdminDAO.DeletarAdmin(admin);
        }
    }
}
