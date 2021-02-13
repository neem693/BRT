import { create } from "./create"
import { fileSave } from "./fileSave"
import { type2 } from "./type2"

export interface WorkOne {
 type2: type2;
 create: Array<create>,
 subject: string,
 work_id: number,
 fileSave: Array<fileSave>,
 is_series: number,
 create_date:Date,
 create_end_date2: Date,
 matter: any[],
 matterSize: number

}