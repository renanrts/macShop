package br.com.les.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.les.dominio.CartaoCredito;
import br.com.les.dominio.Cliente;
import br.com.les.dominio.Endereco;
import br.com.les.dominio.EntidadeDominio;
import br.com.les.util.Resultado;
import br.com.les.viewhelper.VHBaseCadastro;

public class DAOCliente extends AbstractDAO {

	@Override
	public Resultado salvar(EntidadeDominio entidade) {
		
		Cliente cliente = (Cliente) entidade;
		
		Resultado resultado = new Resultado();
		

		String sql = "INSERT INTO CLIENTES (cli_nome, cli_cpf, cli_ativo, cli_email, cli_senha, cli_tel_tipo, cli_tel_ddd, cli_tel_numero, cli_genero, cli_dt_nascimento) "
				+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {

			PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getCpf());
			stmt.setString(3, "ATIVO");
			stmt.setString(4, cliente.getEmail());
			stmt.setString(5, cliente.getSenhas().get(0));
			stmt.setString(6, cliente.getTelefone().getTipoTelefone());
			stmt.setString(7, cliente.getTelefone().getDdd());
			stmt.setString(8, cliente.getTelefone().getNumero());
			stmt.setString(9, cliente.getGenero());
			stmt.setDate(10, new Date(cliente.getDataNascimento().getTimeInMillis()));

			stmt.execute();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next())
				cliente.setId(rs.getInt("cli_id"));
			
			stmt.close();
			
			for(Endereco endereco : cliente.getListEnderecos())
			{
				IDAO dao = new DAOEndereco();
				endereco.setCliId(rs.getInt("cli_id"));
				dao.salvar(endereco);
			}
			
			for(CartaoCredito cartao : cliente.getListCartoes())
			{
				IDAO dao = new DAOCartao();
				cartao.setCliId(rs.getInt("cli_id"));
				dao.salvar(cartao);
			}
			
			con.close();

			resultado.sucesso("Salvo com sucesso!");
			return resultado;

		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			resultado.erro("Erro salvar, por favor, refaça a operação.");
			return resultado;
		}
	}

	@Override
	public Resultado consultar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado alterar(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado excluir(EntidadeDominio entidade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado visualizar(EntidadeDominio e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Resultado consultarExistencia(EntidadeDominio e) {
		Cliente cliente = (Cliente) e;
		Resultado resultado = new Resultado();
		int contagem = 0;

		try {
			
			
			PreparedStatement stmt = null;

			stmt = this.con.prepareStatement("SELECT * FROM CLIENTES WHERE cli_cpf = ?");
			stmt.setString(1, cliente.getCpf());
	
			ResultSet rs = stmt.executeQuery();
						
			while (rs.next()) {
				contagem++;
			}
			
			
			if(contagem == 0){
				resultado.sucesso("Nenhum cliente encontrado.");
			}
			else{
				resultado.sucesso("");
			}
			
			resultado.setContagem(contagem);
			rs.close();
			stmt.close();
			return resultado;
			
		} catch (SQLException e1) {
			
						e1.printStackTrace();
						resultado.erro("Erro de consulta.");
						return resultado;
		}

	}
}
