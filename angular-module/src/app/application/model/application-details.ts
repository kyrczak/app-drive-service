import { Disk } from "../../disk/model/disk";

export interface ApplicationDetails {
    uuid: string;
    name: string;
    size: number;
    disk: Disk;
}
