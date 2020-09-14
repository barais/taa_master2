package kanbandbnr;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import java.io.Serializable;

@Entity
@NamedQueries({ 
	@NamedQuery(name = "BoardKB.findAll", query = "SELECT b FROM BoardKB b"),
	@NamedQuery(name = "BoardKB.findByName", query = "SELECT b FROM BoardKB b WHERE b.name = :name"), 
})
public class BoardKB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1517205058451738936L;

	private Long id;

	private String name;

	private List<ColumnKB> columns = new ArrayList<ColumnKB>();

	public BoardKB() {
	}

	public BoardKB(String name) {
		this.name = name;
	}

	public void addColumn(ColumnKB col) {
		this.columns.add(col);
	}

	@OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
	public List<ColumnKB> getColumns() {
		return columns;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setColumns(List<ColumnKB> colums) {
		this.columns = colums;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
