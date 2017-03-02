package BufferSimulation;
import java.io.IOException;
import java.util.*;

public class BufferSimulation {
	
	public static ArrayList<Request> getPackets(Scanner sc) throws IOException {
		
		int packet_count = sc.nextInt();
		ArrayList<Request> packets = new ArrayList<Request>();
		System.out.println("Number of packets incoming ->" + packet_count);
		
		for(int i = 0; i < packet_count; i++) {
			int a_i = sc.nextInt();
			int p_i = sc.nextInt();
			
			packets.add(new Request(a_i, p_i));
		}
		
		return packets;
	}
	
	public static ArrayList<Response> processRequests(ArrayList<Request> req, Buffer buffer) {
		System.out.println("Packets received");
		ArrayList<Response> response = new ArrayList<Response>();
		
		for(int i = 0; i < req.size(); i++) {
			response.add(Buffer.ProcessPacket(req.get(i)));
		}
		
		return response;
	}
	
	public static void printResponses(ArrayList<Response> response) {
		
		for (int i = 0; i < response.size(); ++i) {
            Response resp = response.get(i);
            if (resp.dropped) {
                System.out.println(-1);
            } else {
                System.out.println(resp.start_time);
            }
        }
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner scanner = new Scanner(System.in);

        int buffer_max_size = scanner.nextInt();
        Buffer buffer = new Buffer(buffer_max_size);

        ArrayList<Request> requests = getPackets(scanner);
        ArrayList<Response> responses = processRequests(requests, buffer);
        printResponses(responses);
	}

}
