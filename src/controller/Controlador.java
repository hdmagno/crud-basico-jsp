package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import persistence.ClienteDao;

@WebServlet("/Controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		
		switch(cmd) {
		
		case "gravar":
			gravar(request, response);
			break;
			
		case "listar":
			listar(request, response);
			break;
			
		case "deletar":
			deletar(request, response);
			break;
			
		case "editar":
			editar(request, response);
			break;
			
		case "atualizar":
			atualizar(request, response);
			break;
		
		default:
			sistema(request, response);
			break;
		}
		
	}

	private void sistema(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.sendRedirect("sistema.jsp");
		
	}

	private void atualizar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ClienteDao dao = new ClienteDao();
		try {
			String id = request.getParameter("id");
			Cliente atualizar = dao.findById(Integer.parseInt(id));
			atualizar.setNome(request.getParameter("nome"));
			atualizar.setEmail(request.getParameter("email"));
			atualizar.setSexo(request.getParameter("sexo"));
			atualizar = dao.update(atualizar);
			dao.update(atualizar);
		} catch (Exception e) {
			request.setAttribute("msg", "Error: " + e.getMessage());
			e.printStackTrace();
		}
		response.sendRedirect("Controlador?cmd=listar");
		
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDao dao = new ClienteDao();
		try {
			String id = request.getParameter("id");
			Cliente editar = dao.findById(Integer.parseInt(id));
			request.setAttribute("editar", editar);
		} catch (Exception e) {
			request.setAttribute("msg", "Error: " + e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher("editar.jsp").forward(request, response);
		
	}

	private void deletar(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ClienteDao dao = new ClienteDao();
		try {
			String id = request.getParameter("id");
			dao.delete(Integer.parseInt(id));
		} catch (Exception e) {
			request.setAttribute("msg", "Error: " + e.getMessage());
			e.printStackTrace();
		}
		response.sendRedirect("Controlador?cmd=listar");
		
	}

	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDao dao = new ClienteDao();
		try {
			List<Cliente> clientes = dao.finAll();
			request.setAttribute("clientes", clientes);
		} catch (Exception e) {
			request.setAttribute("msg", "Error: " + e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher("listar.jsp").forward(request, response);
		
	}

	private void gravar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ClienteDao dao = new ClienteDao();
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String sexo = request.getParameter("sexo");
		Cliente c = new Cliente(nome, email, sexo);
		try {
			dao.create(c);
			request.setAttribute("msg", "Registro Gravado!");
		} catch (Exception e) {
			request.setAttribute("msg", "Error: " + e.getMessage());
			e.printStackTrace();
		}
		request.getRequestDispatcher("sistema.jsp").forward(request, response);
		
	}

}
