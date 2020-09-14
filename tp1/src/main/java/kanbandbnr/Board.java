package kanbandbnr;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Board {

	private Long id;

	private String name;

	private List<Column> columns = new ArrayList<Column>();

	public Board() {
	}

	public Board(String name) {
		this.name = name;
	}

	public void addColumn(Column col) {
		this.columns.add(col);
	}

	@OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
	public List<Column> getColumns() {
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

	public void setColumns(List<Column> colums) {
		this.columns = colums;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
