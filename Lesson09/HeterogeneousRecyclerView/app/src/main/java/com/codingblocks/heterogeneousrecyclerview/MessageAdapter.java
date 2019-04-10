package com.codingblocks.heterogeneousrecyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MessageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<WhatsappMessage> messages;
    private Context context;

    public MessageAdapter(ArrayList<WhatsappMessage> messages, Context context) {
        this.messages = messages;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        WhatsappMessage currentMessage = messages.get(position);

        switch (currentMessage.getTypeOfMessage()) {
            case TEXT_SENT:
                return 0;
            case TEXT_RECEIVED:
                return 1;
            case IMAGE_SENT:
                return 2;
            case IMAGE_RECEIVED:
                return 3;
        }

        return -1;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup,
                                                      int itemType) {
        LayoutInflater li = LayoutInflater.from(context);
        View inflatedView;
        switch (itemType) {
            case 0:
                inflatedView = li.inflate(R.layout.item_msg_sent, viewGroup, false);
                return new MessageSentHolder(inflatedView);
            case 1:
                inflatedView = li.inflate(R.layout.item_msg_received, viewGroup, false);
                return new MessageReceivedHolder(inflatedView);
            case 2:
                inflatedView = li.inflate(R.layout.item_img_sent, viewGroup, false);
                return new ImageSentHolder(inflatedView);
            case 3:
                inflatedView = li.inflate(R.layout.item_img_received, viewGroup, false);
                return new ImageReceivedHolder(inflatedView);
            default:
                return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position) {
        WhatsappMessage currentMessage = messages.get(position);

        switch (getItemViewType(position)){
            case 0 :
                MessageSentHolder messageSentHolder = (MessageSentHolder) viewHolder;
                messageSentHolder.tvTime.setText(currentMessage.getTime());
                messageSentHolder.tvMessage.setText(currentMessage.getMessage());
                break;
            case 1:
                MessageReceivedHolder messageReceivedHolder = (MessageReceivedHolder) viewHolder;
                messageReceivedHolder.tvTime.setText(currentMessage.getTime());
                messageReceivedHolder.tvMessage.setText(currentMessage.getMessage());
                break;
            case 2:
                ImageSentHolder imageSentHolder = (ImageSentHolder) viewHolder;
                imageSentHolder.tvTime.setText(currentMessage.getTime());
                break;
            case 3:
                ImageReceivedHolder imageReceivedHolder = (ImageReceivedHolder) viewHolder;
                imageReceivedHolder.tvTime.setText(currentMessage.getTime());
                break;
        }

    }

    @Override
    public int getItemCount() {
        return messages.size();
    }

    class MessageSentHolder extends RecyclerView.ViewHolder {

        TextView tvMessage, tvTime;

        public MessageSentHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }

    class MessageReceivedHolder extends RecyclerView.ViewHolder {

        TextView tvMessage, tvTime;

        public MessageReceivedHolder(@NonNull View itemView) {
            super(itemView);
            tvMessage = itemView.findViewById(R.id.tvMessage);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }

    class ImageSentHolder extends RecyclerView.ViewHolder {

        ImageView ivMessage;
        TextView tvTime;

        public ImageSentHolder(@NonNull View itemView) {
            super(itemView);
            ivMessage = itemView.findViewById(R.id.ivMessage);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }

    class ImageReceivedHolder extends RecyclerView.ViewHolder {

        ImageView ivMessage;
        TextView tvTime;

        public ImageReceivedHolder(@NonNull View itemView) {
            super(itemView);
            ivMessage = itemView.findViewById(R.id.ivMessage);
            tvTime = itemView.findViewById(R.id.tvTime);
        }
    }

}
