package dmtools;

public class CharacterEffect 
{
	protected String affectedCharacter;
	protected String effectName;
	protected int	roundsRemaining;
	
	public CharacterEffect(String character, String effect, int rounds)
	{
		this.affectedCharacter = character;
		this.effectName = effect;
		this.roundsRemaining = rounds;
	}
	
}
