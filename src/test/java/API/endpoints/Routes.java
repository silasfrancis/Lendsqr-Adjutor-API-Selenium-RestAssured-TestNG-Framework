package API.endpoints;

public class Routes{

    public static String Api_baseURL =  "https://adjutor.lendsqr.com/v2/";
    public static String ApiKey = "Bearer sk_live_NOsySwYtHrNFLpIZlMgAqKdH02U3r7Ho4UpZabHr";

    //Validation
    public static String post_initailzie_bvn = Api_baseURL + "verification/bvn/{bvn}";
    public static String put_getBvndetails = Api_baseURL + "verification/bvn/{bvn}";
    public static String post_initalize_bvnAccounts = Api_baseURL + "verification/bvn/{bvn}/accounts";

//    Credit Bureaus
    public static String get_creditReportCRC = Api_baseURL + "creditbureaus/crc/{bvn}";
    public static String get_creditReportFirstCentral = Api_baseURL + "creditbureaus/firstcentral/{bvn}";

//    Decisioning
    public static String get_decisionModels = Api_baseURL+ "decisioning/models";
    public static String get_decisionModelsDetails = Api_baseURL+ "decisioning/models/{id}/settings";
    public static String post_Oraculi_Borrower_Scoring = Api_baseURL+ "decisioning/models/{id}";

//    Embedded Loans And Payments
//    Loans
    public static String get_loanProducts = Api_baseURL + "loans/products";
    public static String post_initializeLoanApplication = Api_baseURL + "loans/initialize";
    public static String get_loan = Api_baseURL + "loans/{reference}";

//    payment
    public static String post_initailizePayment = Api_baseURL + "payments/initialize";
    public static String get_QueryPayment = Api_baseURL + "payments/{reference}";



}
