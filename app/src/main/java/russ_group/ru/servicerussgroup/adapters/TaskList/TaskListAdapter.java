package russ_group.ru.servicerussgroup.adapters.TaskList;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import russ_group.ru.servicerussgroup.R;
import russ_group.ru.servicerussgroup.models.TaskList.ContentItem;
import russ_group.ru.servicerussgroup.ui.TaskActivity;

public class TaskListAdapter extends RecyclerView.Adapter<TaskListAdapter.ViewHolder> {
//    public Globals globals;
    private List<ContentItem> contentItemList;
    private Context mContext;
    Intent intent;

    SimpleDateFormat oldDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat newDateFormat = new SimpleDateFormat("dd MMMM yyyy");
    Date oldDate;

    public TaskListAdapter(List<ContentItem> contentItemList) {
        this.contentItemList = contentItemList;
    }


    @NonNull
    @Override
    public TaskListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        mContext = viewGroup.getContext();
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.task_list, viewGroup, false);
        return new TaskListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final TaskListAdapter.ViewHolder viewHolder, int i) {
        final ContentItem contentItem = contentItemList.get(i);

        viewHolder.taskIDTextView.setText("Заявка: " + contentItem.getId());
        viewHolder.company_name.setText(contentItem.getClientAddress().getClient().getName().trim());
        viewHolder.company_address.setText(contentItem.getClientAddress().getAddress().getAddress().trim());

        try {
            oldDate = oldDateFormat.parse(contentItem.getExecutionDate().trim());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String dateTime = newDateFormat.format(oldDate);

        viewHolder.date.setText(dateTime);

        viewHolder.company_address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent geoIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="
                        + viewHolder.company_address.getText().toString()));
                mContext.startActivity(geoIntent);
            }
        });

        viewHolder.taskLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(mContext, TaskActivity.class);
                intent.putExtra("taskID", contentItem.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (contentItemList == null) {
            return 0;
        }
        return contentItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        LinearLayout taskLinear;
        TextView taskIDTextView;
        TextView company_name,company_address,date,status,contact_name,work_name,phone_number,phone_number2;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            taskLinear = itemView.findViewById(R.id.taskLinear);
            taskIDTextView = itemView.findViewById(R.id.taskIDTextView);
            company_name = itemView.findViewById(R.id.company_name);
            company_address = itemView.findViewById(R.id.company_address);
            date = itemView.findViewById(R.id.date);
            status = itemView.findViewById(R.id.status);
            contact_name = itemView.findViewById(R.id.contact_name);
            work_name = itemView.findViewById(R.id.work_name);
            phone_number = itemView.findViewById(R.id.phone_number);
            phone_number2 = itemView.findViewById(R.id.phone_number2);
        }
    }
}
