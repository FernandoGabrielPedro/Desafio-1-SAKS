package atividade.saks.dao;

import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import atividade.saks.model.Usuario;
import atividade.saks.criptografia.Criptografia;
import static atividade.saks.dao.AdminDAO.GetAdminPorEmail;
import atividade.saks.model.Admin;

public class UsuarioDAO {
    
    public static void CadastrarUsuario(Usuario usuario) {
        String QUERY = "INSERT INTO usuario (nome, idade, cpf, email, senha, pergunta1, pergunta2, pergunta3, ativo)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Usuario usuarioEmailTeste = GetUsuarioPorEmail(usuario.getEmail());
        Admin adminEmailTeste = GetAdminPorEmail(usuario.getEmail());
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        usuario.setSenha(Criptografia.Criptografar(usuario.getSenha()));
        usuario.setPergunta1(Criptografia.Criptografar(usuario.getPergunta1()));
        usuario.setPergunta2(Criptografia.Criptografar(usuario.getPergunta2()));
        usuario.setPergunta3(Criptografia.Criptografar(usuario.getPergunta3()));

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.setString(1, usuario.getNome());
            preparedStatement.setInt(2, usuario.getIdade());
            preparedStatement.setString(3, usuario.getCpf());
            preparedStatement.setString(4, usuario.getEmail());
            preparedStatement.setString(5, usuario.getSenha());
            preparedStatement.setString(6, usuario.getPergunta1());
            preparedStatement.setString(7, usuario.getPergunta2());
            preparedStatement.setString(8, usuario.getPergunta3());
            preparedStatement.setInt(9, 1);

            if(usuarioEmailTeste == null && adminEmailTeste == null)
                preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    public static List<Usuario> GetUsuarios() {
        List<Usuario> usuarios = new ArrayList<Usuario>();
        String QUERY = "SELECT * FROM usuario WHERE ativo != 0";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            while (resultSet.next()) {
                Usuario usuario = new Usuario();
                
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setIdade(resultSet.getInt("idade"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setPergunta1(resultSet.getString("pergunta1"));
                usuario.setPergunta2(resultSet.getString("pergunta2"));
                usuario.setPergunta3(resultSet.getString("pergunta3"));
                usuario.setAtivo(resultSet.getInt("ativo"));
                
                usuarios.add(usuario);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuarios;
    }
    
    public static Usuario GetUsuarioPorID(int id) {
        Usuario usuario = new Usuario();
        String QUERY = "SELECT * FROM usuario WHERE id="+id;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            if(!resultSet.next()) {
                usuario = null;
                return usuario;
            }
                
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setIdade(resultSet.getInt("idade"));
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setPergunta1(resultSet.getString("pergunta1"));
            usuario.setPergunta2(resultSet.getString("pergunta2"));
            usuario.setPergunta3(resultSet.getString("pergunta3"));
            usuario.setAtivo(resultSet.getInt("ativo"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
    
    public static Usuario GetUsuarioPorEmail(String email) {
        Usuario usuario = new Usuario();
        String QUERY = "SELECT * FROM usuario WHERE ativo != 0 AND email = '"+email+"'";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            if (!resultSet.next()) {
                usuario = null;
                return usuario;
            }
            
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setIdade(resultSet.getInt("idade"));
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setPergunta1(resultSet.getString("pergunta1"));
            usuario.setPergunta2(resultSet.getString("pergunta2"));
            usuario.setPergunta3(resultSet.getString("pergunta3"));
            usuario.setAtivo(resultSet.getInt("ativo"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
    
    public static Usuario GetUsuarioRedefinirSenha(String email, String pergunta1, String pergunta2, String pergunta3) {
        Usuario usuario = new Usuario();
        
        pergunta1 = Criptografia.Criptografar(pergunta1);
        pergunta2 = Criptografia.Criptografar(pergunta2);
        pergunta3 = Criptografia.Criptografar(pergunta3);
        
        String QUERY = "SELECT * FROM usuario WHERE ativo != 0 AND email = '"+email+"' AND pergunta1 = '"+pergunta1+"' AND pergunta2 = '"+pergunta2+"' AND pergunta3 = '"+pergunta3+"'";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            if (!resultSet.next()){
                usuario = null;
                return usuario;
            }
            
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setIdade(resultSet.getInt("idade"));
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setPergunta1(resultSet.getString("pergunta1"));
            usuario.setPergunta2(resultSet.getString("pergunta2"));
            usuario.setPergunta3(resultSet.getString("pergunta3"));
            usuario.setAtivo(resultSet.getInt("ativo"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
    
    public static Usuario EditarUsuario(Usuario usuario, String atributo, String novoValor) {
        String QUERY = "UPDATE usuario SET "+atributo+"='"+novoValor+"' WHERE id = "+usuario.getId();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.execute();
            
            QUERY = "SELECT * FROM usuario WHERE id = "+usuario.getId();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            resultSet = preparedStatement.executeQuery(QUERY);
            
            resultSet.next();
            
            usuario.setId(resultSet.getInt("id"));
            usuario.setNome(resultSet.getString("nome"));
            usuario.setIdade(resultSet.getInt("idade"));
            usuario.setCpf(resultSet.getString("cpf"));
            usuario.setEmail(resultSet.getString("email"));
            usuario.setSenha(resultSet.getString("senha"));
            usuario.setPergunta1(resultSet.getString("pergunta1"));
            usuario.setPergunta2(resultSet.getString("pergunta2"));
            usuario.setPergunta3(resultSet.getString("pergunta3"));
            usuario.setAtivo(resultSet.getInt("ativo"));
            
            System.out.println("Usuario editado com sucesso.");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return usuario;
    }
    
    public static Usuario DeletarUsuario(Usuario usuario) {
        String QUERY = "UPDATE usuario SET ativo=0 WHERE id="+usuario.getId();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.execute();
            
            usuario.setAtivo(0);
            
            System.out.println("Usuario deletado com sucesso.");
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return usuario;
    }
    
    public static Usuario UsuarioLogin(String email,String senha) {
        Usuario usuario = new Usuario();
        String QUERY = "SELECT * FROM usuario WHERE email='"+email+"' AND senha='"+Criptografia.Criptografar(senha)+"' AND ativo != 0";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            if(resultSet.next()) {
                usuario.setId(resultSet.getInt("id"));
                usuario.setNome(resultSet.getString("nome"));
                usuario.setIdade(resultSet.getInt("idade"));
                usuario.setCpf(resultSet.getString("cpf"));
                usuario.setEmail(resultSet.getString("email"));
                usuario.setSenha(resultSet.getString("senha"));
                usuario.setPergunta1(resultSet.getString("pergunta1"));
                usuario.setPergunta2(resultSet.getString("pergunta2"));
                usuario.setPergunta3(resultSet.getString("pergunta3"));
                usuario.setAtivo(resultSet.getInt("ativo"));
            } else {
                usuario = null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return usuario;
    }
}
