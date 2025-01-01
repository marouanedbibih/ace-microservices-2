import {
  CardHeader,
  Typography,
  Input,
  Button,
} from "@material-tailwind/react";
import { MagnifyingGlassIcon, UserPlusIcon } from "@heroicons/react/24/outline";
import { useClientContext } from "../contexts/ClientProvider";

export function ClientTableHeader() {
  const { toggleForm } = useClientContext();
  return (
    <CardHeader floated={false} shadow={false} className="rounded-none"  placeholder={undefined} onPointerEnterCapture={undefined} onPointerLeaveCapture={undefined}>
      <div className="mb-4 flex flex-col justify-between gap-8 md:flex-row md:items-center">
        <div>
          <Typography variant="h5" color="blue-gray"  placeholder={undefined} onPointerEnterCapture={undefined} onPointerLeaveCapture={undefined}>
            Client List
          </Typography>
          <Typography color="gray" className="mt-1 font-normal"  placeholder={undefined} onPointerEnterCapture={undefined} onPointerLeaveCapture={undefined}>
            Manage your clients here.
          </Typography>
        </div>
        <div className="flex w-full shrink-0 gap-2 md:w-max">
          <div className="w-full md:w-72">
            <Input
              label="Search"
              icon={<MagnifyingGlassIcon className="h-5 w-5" />}
              placeholder="Search clients..." onPointerEnterCapture={undefined} onPointerLeaveCapture={undefined} crossOrigin={undefined}            />
          </div>
          <Button
            className="flex items-center gap-3"
            size="sm"
            onClick={toggleForm}  placeholder={undefined} onPointerEnterCapture={undefined} onPointerLeaveCapture={undefined}          >
            <UserPlusIcon strokeWidth={2} className="h-4 w-4" /> Add Client
          </Button>
        </div>
      </div>
    </CardHeader>
  );
}
