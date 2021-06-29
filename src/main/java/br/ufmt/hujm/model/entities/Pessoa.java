package br.ufmt.hujm.model.entities;

import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

@SuppressWarnings("serial")
@Entity
public abstract class Pessoa implements Serializable {
	
	private Long idPessoa;
	
	protected String nome;
	protected String cpf;
	protected String rg;
	
	protected Sexo sexo;
	protected Date dataNascimento;
	protected Cidade cidadeNatal = new Cidade();
	
	protected Nivel nivelEscolaridade;
	
	protected Endereco endereco = new Endereco();
	protected String telResidencial;
	protected String celPrincipal;
	protected String celOpcional;
	protected String contato;
	protected String email;
	
	protected byte[]foto;
	
	@SuppressWarnings("unused")
	private StreamedContent imagem;
	
	public Pessoa(){
		
	}
	
	public Pessoa (Long idPessoa, String nome, String cpf, String rg,
			Sexo sexo, Date dataNascimento, Cidade cidadeNatal,
			Nivel nivelEscolaridade, Endereco endereco,
			String telResidencial, String celPrincipal, String celOpcional,
			String contato, String email, byte[]foto){
		
		this.idPessoa = idPessoa;
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidadeNatal = cidadeNatal;
		this.nivelEscolaridade = nivelEscolaridade;
		this.endereco = endereco;
		this.telResidencial = telResidencial;
		this.celPrincipal = celPrincipal;
		this.celOpcional = celOpcional;
		this.contato = contato;
		this.email = email;
		this.foto = foto;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	public Long getIdPessoa() {
		return idPessoa;
	}
	
	public void setIdPessoa(Long idPessoa) {
		this.idPessoa = idPessoa;
	}

	@Column(length = 100, nullable = false)
	@NotEmpty(message = "Preenchimento obrigatorio!")
	public String getNome(String nome) {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Pessoa(String nome){
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}
	
	@Column(name = "data_nascimento")
	@Temporal(TemporalType.DATE)
	@NotNull(message = "Preenchimento obrigatorio!")
	@Past(message = "Data deve ser anterior a data atual!")
	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	@ManyToOne
	@JoinColumn(name = "id_cidade")
	@NotNull(message = "Preenchimento obrigatorio!")
	public Cidade getCidadeNatal() {
		return cidadeNatal;
	}

	public void setCidadeNatal(Cidade cidadeNatal) {
		this.cidadeNatal = cidadeNatal;
	}

	public Nivel getNivel() {
		return nivelEscolaridade;
	}

	public void setNivel(Nivel nivelEscolaridade) {
		this.nivelEscolaridade = nivelEscolaridade;
	}
	
	@OneToOne(mappedBy = "pessoa")
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public String getTelResidencial() {
		return telResidencial;
	}

	public void setTelResidencial(String telResidencial) {
		this.telResidencial = telResidencial;
	}

	public String getCelPrincipal() {
		return celPrincipal;
	}

	public void setCelPrincipal(String celPrincipal) {
		this.celPrincipal = celPrincipal;
	}

	public String getCelOpcional() {
		return celOpcional;
	}

	public void setCelOpcional(String celOpcional) {
		this.celOpcional = celOpcional;
	}

	public String getContato() {
		return contato;
	}

	public void setContato(String contato) {
		this.contato = contato;
	}

	@Column( length = 255, nullable = false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Lob
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	@Transient
	public StreamedContent getImagem() {
		if(this.getFoto() != null){
			return new DefaultStreamedContent(
					new ByteArrayInputStream(this.getFoto()));
		}
		
		return new DefaultStreamedContent();
	}

	public void setImagem(StreamedContent imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPessoa == null) ? 0 : idPessoa.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (idPessoa == null) {
			if (other.idPessoa != null)
				return false;
		} else if (!idPessoa.equals(other.idPessoa))
			return false;
		return true;
	}
}
