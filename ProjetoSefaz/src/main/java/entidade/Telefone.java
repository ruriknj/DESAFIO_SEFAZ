package entidade;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "TELEFONE")
public class Telefone {

	@Id
	@Column(name = "id")
	@GeneratedValue
	private long id;

	@Column(name = "numero")
	private String numero;

	@Column(name = "ddd")
	private int ddd;

	@Column(name = "tipo")
	private String tipo;

	@Column(name = "editable")
	private boolean editable;

	// @Column
	// private String id_email;

	@ManyToOne
	@JoinColumn(name = "id_email", referencedColumnName = "email", nullable = false)
	private Usuario usuario;

	public int getDdd() {
		return ddd;
	}

	public void setDdd(int ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public boolean isEditable() {
		return editable;
	}

	public void setEditable(boolean editable) {
		this.editable = editable;
	}

	@Override
	public String toString() {
		return "(" + ddd + ")" + numero + " (" + tipo + ")";

	}

}
