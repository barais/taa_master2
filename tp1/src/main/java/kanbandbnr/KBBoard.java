package kanbandbnr;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class KBBoard {

	private Long id;

	private String name;

	private List<KBColumn> columns = new ArrayList<KBColumn>();

	public KBBoard() {
	}

	public KBBoard(String name) {
		this.name = name;
	}

	public void addColumn(KBColumn col) {
		this.columns.add(col);
	}

	@OneToMany(mappedBy = "board", cascade = CascadeType.PERSIST)
	public List<KBColumn> getColumns() {
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

	public void setColumns(List<KBColumn> colums) {
		this.columns = colums;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
