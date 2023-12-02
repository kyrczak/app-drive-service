import { Disk } from "../../disk/model/disk";

export interface ApplicationDetails {
    uuid: number;
    name: string;
    size: number;
    disk: Disk;
}
