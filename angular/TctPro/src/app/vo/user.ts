export interface UserInfo {

     user_id:number;
     nickname:string;
     user_login_id:string;
     password:string;
     email:string;
     access_token: string;
     sns_user_unique_id: string;
     snsType: string;
     sns_email: string;


    
}

export interface SnsBasicUserInfo{
     user_login_id:string;
     password:string
     snsType:string;
     email:string;
     access_token:string;
}