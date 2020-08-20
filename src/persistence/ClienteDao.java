package persistence;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Cliente;

public class ClienteDao extends Dao {
	
	PreparedStatement stmt;
	ResultSet rs;
	
	public Cliente create(Cliente c) throws Exception {
		open();
		String sql = "insert into cliente values (null,?,?,?)";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setString(3, c.getSexo());
		stmt.execute();
		stmt.close();
		return c;
	}
	
	public List<Cliente> finAll() throws Exception {
		List<Cliente> clientes = new ArrayList<>();
		open();
		String sql = "select * from cliente";
		stmt = con.prepareStatement(sql);
		rs = stmt.executeQuery();
		while(rs.next()) {
			Integer id = rs.getInt("id");
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			String sexo = rs.getString("sexo");
			Cliente c = new Cliente(id, nome, email, sexo);
			clientes.add(c);
		}
		close();
		return clientes;
	}
	
	public Boolean delete(int id) throws Exception {
		open();
		String sql = "delete from cliente where id = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, id);
		stmt.execute();
		close();
		return true;
	}
	
	public Cliente update(Cliente c) throws Exception {
		open();
		String sql = "update cliente set nome = ?, email = ?, sexo = ? where id = ?";
		stmt = con.prepareStatement(sql);
		stmt.setString(1, c.getNome());
		stmt.setString(2, c.getEmail());
		stmt.setString(3, c.getSexo());
		stmt.setInt(4, c.getId());
		stmt.execute();
		close();
		return c;
	}
	
	public Cliente findById(int idCliente) throws Exception {
		Cliente c = null;
		open();
		String sql = "select * from cliente where id = ?";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, idCliente);
		rs = stmt.executeQuery();
		if(rs.next()) {
			int id = rs.getInt("id");
			String nome = rs.getString("nome");
			String email = rs.getString("email");
			String sexo = rs.getString("sexo");
			c = new Cliente(id, nome, email, sexo);
		}
		close();
		return c;
	}
	
	public static void main(String[] args) throws Exception {
		
		ClienteDao dao = new ClienteDao();
		Cliente cliente = new Cliente(5, "Maria da Penha", "maria70@gmail.com", "F");		
		dao.update(cliente);
		
	}

}
