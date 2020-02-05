import { createReducer, on, Action } from '@ngrx/store';
import { userinfoTempSave } from '../action/action';
import { UserInfo } from 'src/app/vo/user';

export const userinfoInitialize: UserInfo = {
  user_id:0,
  nickname:"",
  user_login_id:"",
  password:"",
  email:"",
  access_token: "",
  sns_user_unique_id: "",
  snsType: "",
  sns_email: "",
};

/**
 * 신호를 의미
 */
const state:number = 0;

const scoreboardReducer = createReducer(
    null,
    on(userinfoTempSave, (state,{payload}) => ({ ...state, payload })),
  );
  
  export function usuerInfoReducer(state: UserInfo | undefined, action: Action) {
    return scoreboardReducer(state, action);
  }