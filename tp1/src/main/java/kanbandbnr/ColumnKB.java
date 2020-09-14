package kanbandbnr;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ColumnKB {

	private Long id;

	private String title;

	private List<CardKB> cards = new ArrayList<CardKB>();
	
	private BoardKB board;

	public ColumnKB() {
		super();
	}

	public ColumnKB(String title) {
		this.title = title;
	}

	public void addCard(CardKB card) {
		this.cards.add(card);
	}

	@ManyToOne
	public BoardKB getBoard() {
		return board;
	}

	@OneToMany(mappedBy = "column", cascade = CascadeType.PERSIST)
	public List<CardKB> getCards() {
		return cards;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setBoard(BoardKB board) {
		this.board = board;
	}

	public void setCards(List<CardKB> cards) {
		this.cards = cards;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
