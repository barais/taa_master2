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
public class KBColumn {

	private Long id;

	private String title;

	private List<KBCard> cards = new ArrayList<KBCard>();
	
	private KBBoard board;

	public KBColumn() {
		super();
	}

	public KBColumn(String title) {
		this.title = title;
	}

	public void addCard(KBCard card) {
		this.cards.add(card);
	}

	@ManyToOne
	public KBBoard getBoard() {
		return board;
	}

	@OneToMany(mappedBy = "column", cascade = CascadeType.PERSIST)
	public List<KBCard> getCards() {
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

	public void setBoard(KBBoard board) {
		this.board = board;
	}

	public void setCards(List<KBCard> cards) {
		this.cards = cards;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
