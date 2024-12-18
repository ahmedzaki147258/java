class Program3{
	public static void main(String []args){
		try{
			if(args.length != 2){
				throw new Exception("Invalid number of arguments");
			};
			Integer.parseInt(args[0]);
			if(Integer.parseInt(args[0]) < 0){
				throw new Exception(args[0] + " must be a positive integer");
			};

			int i=0;
			while(i < Integer.parseInt(args[0])){
				System.out.println(i+1 + ") " + args[1]);
				i++;
			}
		} catch (NumberFormatException e) {
            System.out.println(args[0] + " is not a valid integer");
        } catch (Exception e){
			System.out.println(e.getMessage());
		}
	}
}
