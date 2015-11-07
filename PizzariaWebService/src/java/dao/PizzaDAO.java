/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Pizza;

/**
 *
 * @author marcelosiedler
 */
public class PizzaDAO {
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
    
    public PizzaDAO()
    {
    
    }
    
    public boolean inserir(Pizza pizza)
    {
        String sql = "INSERT INTO pizza(nome,tamanho,descricao,preco) VALUES(?,?,?,?)";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, pizza.getId());
            pst.setString(2, pizza.getNome());
            pst.setString(3, pizza.getTamanho());
            pst.setString(4, pizza.getDescricao());
            pst.setFloat(5, pizza.getPreco());
            
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean atualizar(Pizza pizza)
    {
        String sql = "UPDATE pizza set nome=?,tamanho=?,descricao=?,preco=? where id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
            pst.setInt(1, pizza.getId());
            pst.setString(2, pizza.getNome());
            pst.setString(3, pizza.getTamanho());
            pst.setString(4, pizza.getDescricao());
            pst.setFloat(5, pizza.getPreco());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    public boolean excluir(Pizza pizza)
    {
        String sql = "DELETE FROM pizza where id=?";
        Boolean retorno = false;
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
          
           
            pst.setInt(1, pizza.getId());
            if(pst.executeUpdate()>0)
            {
                retorno = true;
            }
                
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            retorno = false;
        }
        
        return retorno;
    
    }
    
    public List<Pizza> listar()
    {
         String sql = "SELECT * FROM pizza";
        List<Pizza> retorno = new ArrayList<Pizza>();
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            
            ResultSet res = pst.executeQuery();
            while(res.next())
            {
                Pizza item = new Pizza();
                item.setId(res.getInt("id"));
                item.setNome(res.getString("nome"));
                item.setTamanho(res.getString("tamanho"));
                item.setDescricao(res.getString("descricao"));
                item.setPreco(res.getFloat("preco"));
                
                retorno.add(item);
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }
    public Pizza buscar(Pizza pizza)
    {
         String sql = "SELECT * FROM pizza where id= ?";
        Pizza retorno = null;
        
        PreparedStatement pst = Conexao.getPreparedStatement(sql);
        try {
           
            pst.setInt(1, pizza.getId());
            ResultSet res = pst.executeQuery();
            
            if(res.next())
            {
                retorno = new Pizza();
                retorno.setId(res.getInt("id"));
                retorno.setNome(res.getString("nome"));
                retorno.setTamanho(res.getString("tamanho"));
                retorno.setDescricao(res.getString("descricao"));
                retorno.setPreco(res.getFloat("preco"));
                
                
            }
               
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PizzaDAO.class.getName()).log(Level.SEVERE, null, ex);
            
        }
        
        return retorno;
    
    
    }


}
