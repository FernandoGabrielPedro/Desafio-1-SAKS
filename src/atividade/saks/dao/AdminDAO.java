package atividade.saks.dao;

import atividade.saks.criptografia.Criptografia;
import static atividade.saks.dao.UsuarioDAO.GetUsuarioPorEmail;
import java.sql.*;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import atividade.saks.model.Admin;
import atividade.saks.model.Usuario;

public class AdminDAO {
    
    public static void CadastrarAdmin(Admin admin) {
        String QUERY = "INSERT INTO admin (nome, idade, cpf, email, senha, pergunta1, pergunta2, pergunta3, ativo)"
                + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Usuario usuarioEmailTeste = GetUsuarioPorEmail(admin.getEmail());
        Admin adminEmailTeste = GetAdminPorEmail(admin.getEmail());
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        
        admin.setSenha(Criptografia.Criptografar(admin.getSenha()));
        admin.setPergunta1(Criptografia.Criptografar(admin.getPergunta1()));
        admin.setPergunta2(Criptografia.Criptografar(admin.getPergunta2()));
        admin.setPergunta3(Criptografia.Criptografar(admin.getPergunta3()));

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.setString(1, admin.getNome());
            preparedStatement.setInt(2, admin.getIdade());
            preparedStatement.setString(3, admin.getCpf());
            preparedStatement.setString(4, admin.getEmail());
            preparedStatement.setString(5, admin.getSenha());
            preparedStatement.setString(6, admin.getPergunta1());
            preparedStatement.setString(7, admin.getPergunta2());
            preparedStatement.setString(8, admin.getPergunta3());
            preparedStatement.setInt(9, admin.getAtivo());

            if(usuarioEmailTeste == null && adminEmailTeste == null)
                preparedStatement.execute();
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public static List<Admin> GetAdmins() {
        List<Admin> admins = new ArrayList<Admin>();
        String QUERY = "SELECT * FROM admin WHERE ativo != 0";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            while (resultSet.next()) {
                Admin admin = new Admin();
                
                admin.setId(resultSet.getInt("id"));
                admin.setNome(resultSet.getString("nome"));
                admin.setIdade(resultSet.getInt("idade"));
                admin.setCpf(resultSet.getString("cpf"));
                admin.setEmail(resultSet.getString("email"));
                admin.setSenha(resultSet.getString("senha"));
                admin.setPergunta1(resultSet.getString("pergunta1"));
                admin.setPergunta2(resultSet.getString("pergunta2"));
                admin.setPergunta3(resultSet.getString("pergunta3"));
                admin.setAtivo(resultSet.getInt("ativo"));
                
                admins.add(admin);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return admins;
    }
    
    public static Admin GetAdminPorID(int id) {
        Admin admin = new Admin();
        String QUERY = "SELECT * FROM admin WHERE id="+id;
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            if(!resultSet.next()) {
                admin = null;
                return admin;
            }
                
            admin.setId(resultSet.getInt("id"));
            admin.setNome(resultSet.getString("nome"));
            admin.setIdade(resultSet.getInt("idade"));
            admin.setCpf(resultSet.getString("cpf"));
            admin.setEmail(resultSet.getString("email"));
            admin.setSenha(resultSet.getString("senha"));
            admin.setPergunta1(resultSet.getString("pergunta1"));
            admin.setPergunta2(resultSet.getString("pergunta2"));
            admin.setPergunta3(resultSet.getString("pergunta3"));
            admin.setAtivo(resultSet.getInt("ativo"));
            
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
        return admin;
    }
    
    public static Admin GetAdminPorEmail(String email) {
        Admin admin = new Admin();
        String QUERY = "SELECT * FROM admin WHERE ativo != 0 AND email = '"+email+"'";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            if (!resultSet.next()) {
                admin = null;
                return admin;
            }
            admin.setId(resultSet.getInt("id"));
            admin.setNome(resultSet.getString("nome"));
            admin.setIdade(resultSet.getInt("idade"));
            admin.setCpf(resultSet.getString("cpf"));
            admin.setEmail(resultSet.getString("email"));
            admin.setSenha(resultSet.getString("senha"));
            admin.setPergunta1(resultSet.getString("pergunta1"));
            admin.setPergunta2(resultSet.getString("pergunta2"));
            admin.setPergunta3(resultSet.getString("pergunta3"));
            admin.setAtivo(resultSet.getInt("ativo"));
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return admin;
    }
    
    public static Admin GetAdminRedefinirSenha(String email, String pergunta1, String pergunta2, String pergunta3) {
        Admin admin = new Admin();
        
        pergunta1 = Criptografia.Criptografar(pergunta1);
        pergunta2 = Criptografia.Criptografar(pergunta2);
        pergunta3 = Criptografia.Criptografar(pergunta3);
        
        String QUERY = "SELECT * FROM admin WHERE ativo != 0 AND email = '"+email+"' AND pergunta1 = '"+pergunta1+"' AND pergunta2 = '"+pergunta2+"' AND pergunta3 = '"+pergunta3+"'";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            if (!resultSet.next()) {
                admin = null;
                return admin;
            }
            
            admin.setId(resultSet.getInt("id"));
            admin.setNome(resultSet.getString("nome"));
            admin.setIdade(resultSet.getInt("idade"));
            admin.setCpf(resultSet.getString("cpf"));
            admin.setEmail(resultSet.getString("email"));
            admin.setSenha(resultSet.getString("senha"));
            admin.setPergunta1(resultSet.getString("pergunta1"));
            admin.setPergunta2(resultSet.getString("pergunta2"));
            admin.setPergunta3(resultSet.getString("pergunta3"));
            admin.setAtivo(resultSet.getInt("ativo"));
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        return admin;
    }
    
    public static Admin EditarAdmin(Admin admin, String atributo, String novoValor) {
        String QUERY = "UPDATE admin SET "+atributo+"='"+novoValor+"' WHERE id = "+admin.getId();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.execute();
            
            QUERY = "SELECT * FROM admin WHERE id = "+admin.getId();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            resultSet = preparedStatement.executeQuery(QUERY);
            
            resultSet.next();
            
            admin.setId(resultSet.getInt("id"));
            admin.setNome(resultSet.getString("nome"));
            admin.setIdade(resultSet.getInt("idade"));
            admin.setCpf(resultSet.getString("cpf"));
            admin.setEmail(resultSet.getString("email"));
            admin.setSenha(resultSet.getString("senha"));
            admin.setPergunta1(resultSet.getString("pergunta1"));
            admin.setPergunta2(resultSet.getString("pergunta2"));
            admin.setPergunta3(resultSet.getString("pergunta3"));
            admin.setAtivo(resultSet.getInt("ativo"));
            
            System.out.println("Administrador editado com sucesso.");
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return admin;
    }
    
    public static Admin DeletarAdmin(Admin admin) {
        String QUERY = "UPDATE admin SET ativo=0 WHERE id="+admin.getId();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            preparedStatement.execute();
            
            admin.setAtivo(0);
            
            System.out.println("Administrador deletado com sucesso.");
            
        } catch (SQLException ex) {
            Logger.getLogger(AdminDAO.class.getName()).log(Level.SEVERE, null, ex);
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
        
        return admin;
    }
    
    public static Admin AdminLogin(String email,String senha) {
        Admin admin = new Admin();
        String QUERY = "SELECT * FROM admin WHERE email='"+email+"' AND senha='"+Criptografia.Criptografar(senha)+"' AND ativo != 0";
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            connection = atividade.saks.connection.ConectaDB.createConnectionMySQL();
            preparedStatement = (PreparedStatement) connection.prepareStatement(QUERY);
            
            resultSet = preparedStatement.executeQuery(QUERY);
            
            if(resultSet.next()) {
                admin.setId(resultSet.getInt("id"));
                admin.setNome(resultSet.getString("nome"));
                admin.setIdade(resultSet.getInt("idade"));
                admin.setCpf(resultSet.getString("cpf"));
                admin.setEmail(resultSet.getString("email"));
                admin.setSenha(resultSet.getString("senha"));
                admin.setPergunta1(resultSet.getString("pergunta1"));
                admin.setPergunta2(resultSet.getString("pergunta2"));
                admin.setPergunta3(resultSet.getString("pergunta3"));
                admin.setAtivo(resultSet.getInt("ativo"));
            } else {
                admin = null;
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
        return admin;
    }
}