package spring.beanfactory;
/**
 * 设计FXNewsProvider类用于普遍的新闻处理
 */
public class FXNewsProvider {
	private DowJonesNewsListener djNewsListener;
	private DowJonesNewsPersister djNewsPersister;
	
	public FXNewsProvider(DowJonesNewsListener djNewsListener,	DowJonesNewsPersister djNewsPersister) {
		super();
		this.djNewsListener = djNewsListener;
		this.djNewsPersister = djNewsPersister;
	}
	
	public FXNewsProvider() {
		super();
	}

	public DowJonesNewsListener getDjNewsListener() {
		return djNewsListener;
	}
	public void setDjNewsListener(DowJonesNewsListener djNewsListener) {
		this.djNewsListener = djNewsListener;
	}
	public DowJonesNewsPersister getDjNewsPersister() {
		return djNewsPersister;
	}
	public void setDjNewsPersister(DowJonesNewsPersister djNewsPersister) {
		this.djNewsPersister = djNewsPersister;
	}
	
	
	@Override
	public String toString() {
		return "FXNewsProvider [djNewsListener=" + djNewsListener
				+ ", djNewsPersister=" + djNewsPersister + "]";
	}

	public void printSuc(){
		System.out.println("success...");
	}
}
