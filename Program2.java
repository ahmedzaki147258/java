class Program2{
	public static void main(String []args){
		for(int i=0;i<args.length;i++){
			try{
				if(Integer.parseInt(args[i]) < 0) System.out.println(args[i] + " is negative number");
				else if(Integer.parseInt(args[i]) == 0) System.out.println(args[i] + " is zero number");
				else System.out.println(args[i] + " is positive number");
			}catch (NumberFormatException e) {
            			System.out.println(args[i] + " is not a valid integer");
        		}
			
		}
	}
}
