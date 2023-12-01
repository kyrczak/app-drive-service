import { Disk } from "../../disk/model/disk";

export interface ApplicationDetails {
    id: number;
    name: string;
    size: number;
    disk: Disk;
}
