class Program1{
	public static void main(String []args){
		try{
			if(args.length != 0) throw new Exception("no args needed");
			System.out.println("Hello World from Java");
		} catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
