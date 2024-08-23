package API.endpoints;

public class Routes{

    public static String Api_baseURL =  "https://adjutor.lendsqr.com/v2/";
    public static String ApiKey = "Bearer sk_live_NOsySwYtHrNFLpIZlMgAqKdH02U3r7Ho4UpZabHr";

    //BVN
    public static String post_initailzie_bvn = Api_baseURL + "verification/bvn/{bvn}";
    public static String put_getBvndetails = Api_baseURL + "verification/bvn/{bvn}";
    public static String post_initalize_bvnAccounts = Api_baseURL + "verification/bvn/{bvn}/accounts";


}
