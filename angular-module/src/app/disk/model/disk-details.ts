import { Application } from "src/app/application/model/application";

export interface DiskDetails {
    uuid: string;
    name: string;
    size: number;
    applicationList: Application[];
}