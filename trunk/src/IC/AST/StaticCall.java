package IC.AST;

import java.util.List;

import IC.LIR.PropagatingVisitor;

/**
 * Static method call AST node.
 * 
 * @author Tovi Almozlino
 */
public class StaticCall extends Call {

	private String className;

	public Object accept(Visitor visitor) {
		return visitor.visit(this);
	}
	
	public String accept(PropagatingVisitor<Integer,String> visitor, Integer downInt){
		return visitor.visit(this, downInt);
	}

	/**
	 * Constructs a new static method call node.
	 * 
	 * @param line
	 *            Line number of call.
	 * @param className
	 *            Name of method's class.
	 * @param name
	 *            Name of method.
	 * @param arguments
	 *            List of all method arguments.
	 */
	public StaticCall(int line, String className, String name,
			List<Expression> arguments) {
		super(line, name, arguments);
		this.className = className;
	}

	public String getClassName() {
		return className;
	}

}
